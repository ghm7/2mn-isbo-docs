---
name: generate-erd-drawio
description: Convert Entity-Relationship Diagram exercises from images, PDFs, screenshots, pasted text, or Markdown into diagrams.net/drawio .drawio files using Chen ER notation. Use when Codex must read an ERD task statement or existing ERD image/PDF, infer entities, attributes, keys, relationships, cardinalities, multivalued/derived/composite attributes, or specialization/generalization, and generate a drawio file that matches the base-de-datos/03162026.md reference style.
---

# Generate ERD Drawio

## Workflow

1. Read the source exercise completely.
   - For attached images/screenshots, inspect the diagram and task text visually.
   - For PDFs, extract embedded text first when available. Try common tools in this order when present: `pdftotext`, Python PDF libraries, then Ghostscript text output:
     `gs -q -dNOPAUSE -dBATCH -sDEVICE=txtwrite -sOutputFile=- file.pdf`.
   - Inspect pages/images if text extraction misses diagrams, scans, or handwriting.
   - Preserve Spanish labels from the source unless the user asks for normalization.

2. Build a compact ER model before drawing.
   - Identify each entity once.
   - List attributes under the owning entity or relationship.
   - Mark key attributes, multivalued attributes, derived attributes, and composite attribute children.
   - Represent relationships as named diamonds with participants and `1`/`N` cardinalities.
   - Represent specialization/generalization with a triangle labeled `es`.
   - Treat pure context nouns as context, not entities, unless the exercise stores attributes for them.
   - Use a supertype/subtype specialization when categories share base attributes but have category-specific attributes.
   - Put attributes on relationships when the values describe the association, for example schedule data for an emission or start/end dates for a contract period.

3. Load `references/chen-reference-design.md` when deciding notation or styling.

4. Generate the diagram.
   - Use the installed drawio MCP/editor to create and edit the diagram.
   - Use the same shapes and styles from the reference: rectangles, ellipses, diamonds, plain connector lines, and separate `1`/`N` text labels.
   - With the drawio MCP, import XML with `import_diagram` using `data`, `format`, `mode`, and `target_page` for `replace`/`add`; export with `export_diagram` using `target_page`, `format`, and `output_path` when saving to disk.
   - If the drawio MCP tools are not exposed in the current session, stop and tell the user that the drawio MCP is unavailable instead of hand-generating a replacement file.

5. Review the `.drawio` result before finishing.
   - Check that all entities, attributes, keys, relationship names, and cardinalities from the exercise are present.
   - Check that the output uses Chen notation, not relational table notation or crow's-foot notation.
   - Validate the saved file parses as XML.
   - Always render and inspect a visual preview before finishing. Prefer exporting SVG/PNG through drawio MCP and rendering with a browser/headless Chrome when available; ImageMagick may fail on drawio SVGs that contain modern `light-dark(...)` CSS.
   - Refine with drawio MCP when the preview shows overlaps, crowded attributes, missing labels, or rotated/unreadable specialization labels.

## Output Rules

- Save the file next to the source exercise unless the user gives a path. Use a clear suffix such as `_erd.drawio`.
- Keep labels short and faithful to the exercise.
- Use `1` and `N` cardinality labels near relationship connectors.
- Add a short note in the final response with the output path and any assumptions made while inferring missing keys or cardinalities.
